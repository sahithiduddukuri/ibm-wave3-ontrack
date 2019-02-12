import { HomeComponent } from './../components/home/home.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule, MatIconModule, MatLabel } from '@angular/material';
import { CardComponent } from '../components/card/card.component';
import { OntrackMaterialModule } from './ontrack.material.module';

@NgModule({
  declarations: [HomeComponent, CardComponent],
  imports: [
    CommonModule,
  MatCardModule,
  OntrackMaterialModule
  ],
  exports: [HomeComponent, CardComponent]
})
export class OntrackModule { }
