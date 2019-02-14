import { LogincompComponent } from './ontrack/components/logincomp/logincomp.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CardComponent } from './ontrack/components/card/card.component';
import { HomeComponent } from './ontrack/components/home/home.component';


const routes: Routes = [
  {
    path: 'AddToCart', component: CardComponent
  },
  {
    path: 'login' , component: LogincompComponent
  },
  {
    path: '**' , component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
