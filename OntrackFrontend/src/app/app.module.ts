
import { SearchService } from './ontrack/components/search/search.service';
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
import { HttpClientModule } from '@angular/common/http';
import { RegistrationcompComponent } from './ontrack/components/registrationcomp/registrationcomp.component';
import { ChildregComponent } from './ontrack/components/registrationcomp/childreg/childreg.component';
import { RegserviceService } from './ontrack/regservice.service';





@NgModule({
  declarations: [
    AppComponent,
    // RegistrationcompComponent,
    // ChildregComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    OntrackModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [OntrackserviceService, SearchService, RegserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
