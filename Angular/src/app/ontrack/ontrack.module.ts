import { HomeComponent } from './../components/home/home.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TrackMaterialModule } from './ontrack.material.module';
import { MatCardModule } from '@angular/material';
import { CardComponent } from '../components/card/card.component';

@NgModule({
  declarations: [HomeComponent, CardComponent],
  imports: [
    CommonModule,
  TrackMaterialModule,
  MatCardModule
  ],
  exports: [HomeComponent, CardComponent]
})
export class OntrackModule { }
