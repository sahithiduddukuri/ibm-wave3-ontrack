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

// import { RegcompComponent } from './ontrack/components/regcomp/regcomp.component';
// import { ChildregcompComponent } from './ontrack/components/regcomp/childregcomp/childregcomp.component';




@NgModule({
  declarations: [
    AppComponent,

    // RegcompComponent,
    // ChildregcompComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    OntrackModule,

    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule

  ],
  providers: [OntrackserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
