import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { SetNewPasswordComponent } from './set-new-password/set-new-password.component';


const routes: Routes = [
  // {path:'set-pass',component:SetNewPasswordComponent}
  // {path:'', component:RegistrationPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
