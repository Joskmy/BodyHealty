  import { NgModule } from '@angular/core';
  import { RouterModule, Routes } from '@angular/router';
  import { HomeComponent } from './home/home.component';
  import { CitaComponent } from './cita/cita.component';
  import { SoporteComponent } from './soporte/soporte.component';
  import { ServicioComponent } from './servicio/servicio.component';
  import { LoginComponent } from './login/login.component';

  const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'home', component: HomeComponent },
    { path: '', component: LoginComponent },
    { path: 'cita', component: CitaComponent},
    { path: 'soporte', component: SoporteComponent},
    { path: 'servicio', component: ServicioComponent },
    { path: '**', redirectTo: '', pathMatch: 'full' }
  ];


  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }
