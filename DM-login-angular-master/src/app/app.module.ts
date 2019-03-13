import { HomeService } from './services/Home.service';
import { LoginService } from './login/login.service';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// tslint:disable-next-line:max-line-length
import { MatFormFieldModule, MatIconModule, MatInputModule, MatButtonModule, MatToolbarModule, MatNativeDateModule } from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { ContainerComponent } from './container/container.component';
<<<<<<< HEAD
import { ChartsService } from './services/charts.service';
import { ChartComponent } from './chart/app.chart';

=======
import { ButtonComponent } from './button/button.component';
import { HomeComponent } from './home/home.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatCardModule} from '@angular/material/card';
>>>>>>> fc5736e7aacd068685947891433425cd6502ed1c

@NgModule({
  declarations: [
    AppComponent,
    ContainerComponent,
<<<<<<< HEAD
    // ChartComponent
=======
    ButtonComponent,
    LoginComponent,
    HeaderComponent, FooterComponent, HomeComponent
>>>>>>> fc5736e7aacd068685947891433425cd6502ed1c
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatDatepickerModule,
    MatCardModule,
    MatNativeDateModule
  ],
  providers: [
<<<<<<< HEAD
   LoginService, HomeService, ChartsService
=======
   LoginService, HomeService, MatDatepickerModule, MatNativeDateModule
>>>>>>> fc5736e7aacd068685947891433425cd6502ed1c
  ],
  bootstrap: [AppComponent],
  exports: [ContainerComponent,
    ButtonComponent,
    LoginComponent,HeaderComponent, FooterComponent, HomeComponent]
})
export class AppModule { }
