<<<<<<< HEAD
=======

import { SearchService } from './ontrack/components/search/search.service';
>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd
import { MatDialogModule } from '@angular/material/dialog';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OntrackModule } from './ontrack/ontrack.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { OntrackserviceService } from './ontrack/ontrackservice.service';
<<<<<<< HEAD
import { AuthenticationService } from './ontrack/components/authentication.service';
import { from } from 'rxjs';
=======
import { HttpClientModule } from '@angular/common/http';
import { RegistrationcompComponent } from './ontrack/components/registrationcomp/registrationcomp.component';
import { ChildregComponent } from './ontrack/components/registrationcomp/childreg/childreg.component';
import { RegserviceService } from './ontrack/regservice.service';




>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
=======
    // RegistrationcompComponent,
    // ChildregComponent
>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    OntrackModule,
    BrowserAnimationsModule,
    FormsModule,
<<<<<<< HEAD
    ReactiveFormsModule

  ],
  providers: [OntrackserviceService, AuthenticationService],
=======
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [OntrackserviceService, SearchService, RegserviceService],
>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd
  bootstrap: [AppComponent]
})
export class AppModule { }
