import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardComponent } from './ontrack/components/card/card.component';
import { LogincompComponent } from './ontrack/components/logincomp/logincomp.component';
import { HomeComponent } from './ontrack/components/home/home.component';


const routes: Routes = [
<<<<<<< HEAD
  {path: 'login', component: LogincompComponent},
  {path: '**', component: HomeComponent}

];


=======
  {
    path: 'AddToCart', component: CardComponent
  },
  {
    path: 'registration', component: RegistrationcompComponent
  },
  {
    path: 'onKey($event)', component: HomeComponent
  }
];

>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
