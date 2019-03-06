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
import { SearchComponent } from './ontrack/components/search/search.component';
import { BuyingHistoryComponent } from './ontrack/components/buying-history/buying-history.component';
// import { BuyingHistoryComponent } from './ontrack/components/buying-history/buying-history.component';


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
    path: 'AddToCart1', component: CartComponent
  },
  {
    path: 'continue', component: HomeComponent
  },
  {
    path: 'continue3', component: HomeComponent
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
    path: 'buy2', component: BuyComponent
  },
  {
    path: 'buy3', component: BuyComponent
  },
  {
    path: 'AddtoCart', component: CartComponent
  },
  {
    path: 'AddtoCart1', component: CartComponent
  },
  {
    path: 'cartbutton', component: BuyingHistoryComponent
  },
  {
    path: 'profile', component: ProfileComponent
  },
  {
    path: 'search', component: SearchComponent
  },
  {
    path: 'search/:brand', component: SearchComponent
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
