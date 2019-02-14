

import { SearchComponent } from './components/search/search.component';
import { HomeComponent } from './components/home/home.component';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


// import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule, MatIconModule, MatLabel, MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { OntrackMaterialModule } from './ontrack.material.module';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { RegcompComponent } from './components/regcomp/regcomp.component';
import { ChildregcompComponent } from './components/regcomp/childregcomp/childregcomp.component';
import { CardComponent } from './components/card/card.component';
import { DailogComponent } from './components/dailog/dailog.component';


 @NgModule({
  declarations: [HomeComponent, CardComponent, SearchComponent, RegcompComponent, ChildregcompComponent, DailogComponent ],

  imports: [
  CommonModule,
  MatCardModule,
  OntrackMaterialModule,
  BrowserAnimationsModule

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
