import { SearchComponent } from './../components/search/search.component';
import { HomeComponent } from './../components/home/home.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule, MatIconModule, MatLabel } from '@angular/material';
import { CardComponent } from '../components/card/card.component';
import { OntrackMaterialModule } from './ontrack.material.module';

@NgModule({
  declarations: [HomeComponent, CardComponent, SearchComponent],
  imports: [
    CommonModule,
  MatCardModule,
  OntrackMaterialModule
  ],
  exports: [HomeComponent, CardComponent, SearchComponent]
})
export class OntrackModule { }
