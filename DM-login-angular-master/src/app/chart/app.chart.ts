import { Component } from '@angular/core';
import { Chart } from 'chart.js/dist/Chart.bundle.js';
import { ChartsService } from '../services/charts.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-chart',
  templateUrl: './app.chart.html',
  styleUrls: ['./app.chart.scss']
})
export class ChartComponent {
  chart = [];
  date: any;
  slot: String;
  formatDate: any;

  constructor(private chartsService: ChartsService, private datePipe: DatePipe) {}

  // getSelectedSlot(value: String) {
  //  console.log('this is the value of selected', value);
  //  this.slot = value;
  // }
  getChartInfo(dateValue: Date, slotType: String) {
    this.date = dateValue;
    this.slot = slotType;
    this.formatDate = this.datePipe.transform(dateValue, 'yyyy-MM-dd');
    console.log('date ', dateValue);
    console.log('slot type value', slotType);
    console.log('Date after format', this.formatDate);
    this.chartsService.getJSON(this.formatDate, this.slot).subscribe(res => {
      console.log('res from json server', res);
        let lat;
        let long;
        let allNodes;
      lat = res.map(e => {  
        return e.Route.map(f => {
          if (f != null) {
          return f.node_X;
          }
        });
      });
      long = res.map(e => {
        return e.Route.map(f => {
          if (f != null) {
          return f.node_Y;
          }
        });
      });
      allNodes = res.map(e => {
        return  e.Route.map(f => {
          return f.nodeId;
        });
      });
      // let nodes = [];
      // console.log(allNodes, lat, long);
      // allNodes.forEach((res: any) => {
      //   nodes.push(res);
      // });
      this.newChart(lat[0], lat[0], long[0]);
    });
  }

  newChart(allNodes: any, lat: any, long: any) {
    this.chart = new Chart('canvas', {
      type: 'line',
      data: {
        labels: allNodes,
        datasets: [
          {
            data: lat,
            borderColor: '#3cba9f',
            fill: false,
          },
          {
            data: long,
            borderColor: '#ffcc00',
            fill: false,
          }
        ]
      },
      options: {
        legend: {
          display: false
        },
        scales: {
          xAxes: [
            {
              display: true
            }
          ],
          yAxes: [
            {
              display: true
            }
          ]
        }
      }
    });
  }
}
