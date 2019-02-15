import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardComponent } from './ontrack/components/card/card.component';
import { LogincompComponent } from './ontrack/components/logincomp/logincomp.component';
import { HomeComponent } from './ontrack/components/home/home.component';


const routes: Routes = [
  {path: 'login', component: LogincompComponent},
  {path: '**', component: HomeComponent}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
