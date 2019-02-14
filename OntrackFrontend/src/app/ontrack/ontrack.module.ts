import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { DailogComponent } from './components/dailog/dailog.component';
import { MatCardModule, MatIconModule, MatLabel, MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { OntrackMaterialModule } from './ontrack.material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchComponent } from './components/search/search.component';
import { HomeComponent } from './components/home/home.component';
import { CardComponent } from './components/card/card.component';

 @NgModule({
  declarations: [HomeComponent, CardComponent, SearchComponent, DailogComponent ],
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
      DailogComponent,
    ],
  exports: [HomeComponent, CardComponent, SearchComponent, DailogComponent ]
})
export class OntrackModule { }
