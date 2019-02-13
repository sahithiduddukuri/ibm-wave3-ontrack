import { MatDialogModule } from '@angular/material/dialog';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OntrackModule } from './ontrack/ontrack.module';
<<<<<<< HEAD
=======
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { OntrackserviceService } from './ontrack/ontrackservice.service';

// import { RegcompComponent } from './ontrack/components/regcomp/regcomp.component';
// import { ChildregcompComponent } from './ontrack/components/regcomp/childregcomp/childregcomp.component';


>>>>>>> 287d03ec9dc1d328c335c6d13801301a9b5393f8


@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
=======
    // RegcompComponent,
    // ChildregcompComponent
>>>>>>> 287d03ec9dc1d328c335c6d13801301a9b5393f8
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    OntrackModule,
<<<<<<< HEAD
    MatDialogModule,
=======
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule
>>>>>>> 287d03ec9dc1d328c335c6d13801301a9b5393f8
  ],
  providers: [OntrackserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
