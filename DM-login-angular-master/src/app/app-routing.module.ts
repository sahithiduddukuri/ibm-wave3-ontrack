import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ChartComponent } from './chart/app.chart';
import { ContainerComponent } from './container/container.component';
import { ButtonComponent } from './button/button.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'chart', component: ChartComponent},
  {path: 'home', component: HomeComponent},
  {path: 'container', component: ContainerComponent},
  {path: 'container1', component: ButtonComponent},
  {path: 'login1', component: ButtonComponent},
  {path: 'checkcontainer', component: ContainerComponent},
{path: 'checkroute', component: HomeComponent},
  {path: '', component: LoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
