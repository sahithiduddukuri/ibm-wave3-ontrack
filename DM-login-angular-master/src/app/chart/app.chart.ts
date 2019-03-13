import { Component, OnInit } from "@angular/core";
import { Chart } from "chart.js/dist/Chart.bundle.js";
import { ChartsService } from '../services/charts.service';

@Component({
  selector: "app-chart",
  templateUrl: "./app.chart.html",
  styleUrls: ["./app.chart.scss"]
})
export class ChartComponent implements OnInit {
  chart = [];

  constructor(private chartsService: ChartsService) {}

  ngOnInit() {
    this.getChartInfo();
  }

  getChartInfo() {
    this.chartsService.getJSON("11-04-2019", "B").subscribe(res => {
      console.log("res from json server", res);
        let lat;
        let long;
        let allNodes;
      lat = res.map(e => {
          return e.Route.map(f => {
          return f.node_X;
        });
      });
      long = res.map(e => {
        return e.Route.map(f => {
          return f.node_Y;
        });
      });
      allNodes = res.map(e => {
        return  e.Route.map(f => {
          return f.nodeId;
        });
      });
      let nodes = [];
      console.log(allNodes, lat, long);
      allNodes.forEach((res: any) => {
        nodes.push(res);
      });
      this.newChart(lat[0], lat[0], long[0]);
    });
  }

  newChart(allNodes: any, lat: any, long: any) {
    this.chart = new Chart("canvas", {
      type: "line",
      data: {
        labels: allNodes,
        datasets: [
          {
            data: lat,
            borderColor: "#3cba9f",
            fill: false,
            // label: "latitude",
            // title: "latitude"
          },
          {
            data: long,
            borderColor: "#ffcc00",
            fill: false,
            // label: "longitude",
            // title: "longitude"
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
