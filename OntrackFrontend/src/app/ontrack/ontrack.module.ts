
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
<<<<<<< HEAD
// import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule, MatIconModule, MatLabel, MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { CardComponent } from '../components/card/card.component';
import { OntrackMaterialModule } from './ontrack.material.module';
import { DailougeComponent } from '../components/dailouge/dailouge.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [HomeComponent, CardComponent, SearchComponent, DailougeComponent],
=======
import { MatCardModule, MatIconModule, MatLabel } from '@angular/material';
import { OntrackMaterialModule } from './ontrack.material.module';
import { HomeComponent } from './components/home/home.component';
import { CardComponent } from './components/card/card.component';
import { SearchComponent } from './components/search/search.component';
import { RegcompComponent } from './components/regcomp/regcomp.component';
import { ChildregcompComponent } from './components/regcomp/childregcomp/childregcomp.component';

@NgModule({
  declarations: [HomeComponent, CardComponent, SearchComponent, RegcompComponent, ChildregcompComponent],
>>>>>>> 287d03ec9dc1d328c335c6d13801301a9b5393f8
  imports: [
  CommonModule,
  MatCardModule,
  OntrackMaterialModule,
  BrowserAnimationsModule,

  ],
<<<<<<< HEAD
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
=======
  exports: [HomeComponent, CardComponent, SearchComponent, RegcompComponent, ChildregcompComponent]
>>>>>>> 287d03ec9dc1d328c335c6d13801301a9b5393f8
})
export class OntrackModule { }
