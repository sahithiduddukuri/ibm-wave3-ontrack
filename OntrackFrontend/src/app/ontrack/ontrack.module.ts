
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule, MatIconModule, MatLabel } from '@angular/material';
import { OntrackMaterialModule } from './ontrack.material.module';
import { HomeComponent } from './components/home/home.component';
import { CardComponent } from './components/card/card.component';
import { SearchComponent } from './components/search/search.component';
import { RegcompComponent } from './components/regcomp/regcomp.component';
import { ChildregcompComponent } from './components/regcomp/childregcomp/childregcomp.component';

@NgModule({
  declarations: [HomeComponent, CardComponent, SearchComponent, RegcompComponent, ChildregcompComponent],
  imports: [
    CommonModule,
  MatCardModule,
  OntrackMaterialModule
  ],
  exports: [HomeComponent, CardComponent, SearchComponent, RegcompComponent, ChildregcompComponent]
})
export class OntrackModule { }
