import { NgModule } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule, MatGridListModule} from '@angular/material';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatMenuModule} from '@angular/material/menu';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';
// import {FlexLayoutModule} from '@angular/flex-layout';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import { DailougeComponent } from '../components/dailouge/dailouge.component';


@NgModule({
    declarations: [],
    imports: [
    MatCardModule,
      MatButtonModule,
      MatIconModule,
      MatToolbarModule,
      MatMenuModule, MatFormFieldModule,
       MatInputModule, MatTooltipModule, MatSnackBarModule, MatDialogModule, MatSidenavModule, MatListModule, 
       MatGridListModule,
       MatInputModule
      ] ,
      exports: [
        MatCardModule,
        MatButtonModule,
        MatIconModule,
        MatToolbarModule,
        MatMenuModule, MatFormFieldModule,
<<<<<<< HEAD
        MatInputModule, MatTooltipModule, MatSnackBarModule, MatDialogModule, MatSidenavModule, MatListModule
=======
         MatInputModule, MatTooltipModule, MatSnackBarModule, MatDialogModule, MatSidenavModule, MatListModule,
          MatGridListModule,
          MatInputModule
>>>>>>> 287d03ec9dc1d328c335c6d13801301a9b5393f8
         ]
   })
  export class OntrackMaterialModule { }
