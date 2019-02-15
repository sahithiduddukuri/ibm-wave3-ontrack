<<<<<<< HEAD
=======
import { HttpClient } from '@angular/common/http';
>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd


import { SearchComponent } from './components/search/search.component';
import { HomeComponent } from './components/home/home.component';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
<<<<<<< HEAD
import { FormsModule } from '@angular/forms';
=======

>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd

// import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule, MatIconModule, MatLabel, MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { OntrackMaterialModule } from './ontrack.material.module';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

<<<<<<< HEAD
import { RegcompComponent } from './components/regcomp/regcomp.component';
import { ChildregcompComponent } from './components/regcomp/childregcomp/childregcomp.component';
import { CardComponent } from './components/card/card.component';
import { DailogComponent } from './components/dailog/dailog.component';
import { LogincompComponent } from './components/logincomp/logincomp.component';


 @NgModule({
  // tslint:disable-next-line:max-line-length
  declarations: [HomeComponent, CardComponent, SearchComponent, RegcompComponent, ChildregcompComponent, DailogComponent, LogincompComponent ],

  imports: [
  CommonModule,
  FormsModule,
  MatCardModule,
  OntrackMaterialModule,
  BrowserAnimationsModule

=======
import { CardComponent } from './components/card/card.component';

import { RegistrationcompComponent } from './components/registrationcomp/registrationcomp.component';
import { ChildregComponent } from './components/registrationcomp/childreg/childreg.component';
import { DailogComponent } from './components/dailog/dailog.component';
import {MatFormFieldModule} from '@angular/material/form-field';
 @NgModule({
  declarations: [HomeComponent, CardComponent, SearchComponent, RegistrationcompComponent, ChildregComponent, DailogComponent ],


  imports: [
  CommonModule,
  MatCardModule,
  OntrackMaterialModule,
  BrowserAnimationsModule,
  MatFormFieldModule
>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd
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
<<<<<<< HEAD
  exports: [HomeComponent, CardComponent, SearchComponent, DailogComponent, LogincompComponent
   ]
=======


  exports: [HomeComponent, CardComponent, SearchComponent, DailogComponent, RegistrationcompComponent, ChildregComponent ]

>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd
})
export class OntrackModule { }
