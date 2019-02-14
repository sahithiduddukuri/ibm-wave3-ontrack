import { DailogComponent } from './components/dailog/dailog.component';
import { SearchComponent } from './components/search/search.component';
import { HomeComponent } from './components/home/home.component';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
 import { MatCardModule, MatIconModule, MatLabel, MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { OntrackMaterialModule } from './ontrack.material.module';
 import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardComponent } from './components/card/card.component';
import { RegistrationcompComponent } from './components/registrationcomp/registrationcomp.component';
import { ChildregComponent } from './components/registrationcomp/childreg/childreg.component';

 @NgModule({
  declarations: [HomeComponent, CardComponent, SearchComponent, DailogComponent, RegistrationcompComponent, ChildregComponent ],
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

  exports: [HomeComponent, CardComponent, SearchComponent, DailogComponent, RegistrationcompComponent, ChildregComponent ]

})
export class OntrackModule { }
