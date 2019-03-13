import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
<<<<<<< HEAD
import { ChartComponent } from './chart/app.chart';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'chart', component: ChartComponent}
=======
import { ContainerComponent } from './container/container.component';
import { ButtonComponent } from './button/button.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'container', component: ContainerComponent},
  {path: 'container1', component: ButtonComponent},
  {path: 'login1', component: ButtonComponent},
  {path: 'checkcontainer', component: ContainerComponent},
{path: 'checkroute', component: HomeComponent},
  {path: '', component: LoginComponent}
>>>>>>> fc5736e7aacd068685947891433425cd6502ed1c
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
