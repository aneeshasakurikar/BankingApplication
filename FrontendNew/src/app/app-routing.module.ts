import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AppComponent } from './app.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ForgotUserIdComponent } from './forgot-user-id/forgot-user-id.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { NetbankingRegistrationComponent } from './netbanking-registration/netbanking-registration.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { SetNewPasswordComponent } from './set-new-password/set-new-password.component';

const routes: Routes = [
  // {path:'set-pass',component:SetNewPasswordComponent}
  {path:'', component:AppComponent},
  {path:'login', component:LoginPageComponent},
  { path:'register', component:RegistrationPageComponent },
  { path:'forgotId',component:ForgotUserIdComponent},
  { path:'forgotPass',component:ForgotPasswordComponent},
  {path:'adminlogin', component:AdminLoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
