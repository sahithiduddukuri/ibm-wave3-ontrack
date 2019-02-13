import { SearchComponent } from './../components/search/search.component';
import { HomeComponent } from './../components/home/home.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
// import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule, MatIconModule, MatLabel, MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { CardComponent } from '../components/card/card.component';
import { OntrackMaterialModule } from './ontrack.material.module';
import { DailougeComponent } from '../components/dailouge/dailouge.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [HomeComponent, CardComponent, SearchComponent, DailougeComponent],
  imports: [
  CommonModule,
  MatCardModule,
  OntrackMaterialModule,
  BrowserAnimationsModule,

  ],
  providers: [{ provide: MatDialogModule, useValue: {} },
    { provide: MatIconModule, useValue: [] },
    {
       provide: MatLabel, useValue: {}
    },
    { provide: MatDialogRef, useValue: {} },
    {
      provide: MAT_DIALOG_DATA, useValue: {}
    }
    ],
    entryComponents: [
      DailougeComponent,
    ],
  exports: [HomeComponent, CardComponent, SearchComponent, DailougeComponent]
})
export class OntrackModule { }
