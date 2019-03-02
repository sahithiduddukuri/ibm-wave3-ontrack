import { ProfileComponent } from './ontrack/components/profile/profile.component';
import { BuyComponent } from './ontrack/components/buy/buy.component';
// import { CartComponent } from './ontrack/components/cart/cart.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CardComponent } from './ontrack/components/card/card.component';
import { RegistrationcompComponent } from './ontrack/components/registrationcomp/registrationcomp.component';
import { HomeComponent } from './ontrack/components/home/home.component';
import { LoginComponent } from './ontrack/components/login/login.component';
import { CartComponent } from './ontrack/components/cart/cart.component';


const routes: Routes = [
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'signup', component: RegistrationcompComponent
  },
  {
    path: 'AddToCart', component: CartComponent
  },
  {
    path: 'continue', component: HomeComponent
  },
  {
    path: 'buy', component: BuyComponent
  },
  {
    path: 'shopping', component: HomeComponent
  },
  {
    path: 'buys', component: BuyComponent
  },
  {
    path: 'buy1', component: BuyComponent
  },
  {
    path: 'AddtoCart', component: CartComponent
  },
  {
    path: 'cartbutton', component: CartComponent
  },
  {
    path: 'profile', component: ProfileComponent
  },
  {
    path: '**', component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
