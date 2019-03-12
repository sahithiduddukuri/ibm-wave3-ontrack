import { HomeService } from './services/Home.service';
import { LoginService } from './login/login.service';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule} from './login/login.module';
import { SharedModule } from './shared/shared.module';
import { HomeModule } from './home/home.module';
import { ContainerComponent } from './container/container.component';


@NgModule({
  declarations: [
    AppComponent,
    ContainerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LoginModule,
    BrowserAnimationsModule,
    SharedModule,
    ReactiveFormsModule,
    FormsModule,
    HomeModule
  ],
  providers: [
   LoginService, HomeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
