import { DailogComponent } from './components/dailog/dailog.component';
import { SearchComponent } from './components/search/search.component';
import { HomeComponent } from './components/home/home.component';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
<<<<<<< HEAD

// import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule, MatIconModule, MatLabel, MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { OntrackMaterialModule } from './ontrack.material.module';
import { DailougeComponent } from '../components/dailouge/dailouge.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchComponent } from './components/search/search.component';
import { HomeComponent } from './components/home/home.component';
import { RegcompComponent } from './components/regcomp/regcomp.component';
import { ChildregcompComponent } from './components/regcomp/childregcomp/childregcomp.component';
import { CardComponent } from './components/card/card.component';


@NgModule({
  declarations: [HomeComponent, CardComponent, SearchComponent,  RegcompComponent, ChildregcompComponent],

=======
 import { MatCardModule, MatIconModule, MatLabel, MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { OntrackMaterialModule } from './ontrack.material.module';
 import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardComponent } from './components/card/card.component';

 @NgModule({
  declarations: [HomeComponent, CardComponent, SearchComponent, DailogComponent ],
>>>>>>> 26cd6d9b87f00ea4917739773564eeb835638d78
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
<<<<<<< HEAD
    }
     ],
    // entryComponents: [
    //   DailougeComponent,
    // ],
  exports: [HomeComponent, CardComponent, SearchComponent, RegcompComponent, ChildregcompComponent]
=======
     }
    ],
    entryComponents: [
       DailogComponent,
    ],

  exports: [HomeComponent, CardComponent, SearchComponent, DailogComponent ]
>>>>>>> 26cd6d9b87f00ea4917739773564eeb835638d78

})
export class OntrackModule { }
