import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminApprovalComponent } from './admin-approval/admin-approval.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AppComponent } from './app.component';
import { CheckStatusComponent } from './check-status/check-status.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ForgotUserIdComponent } from './forgot-user-id/forgot-user-id.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { NetbankingRegistrationComponent } from './netbanking-registration/netbanking-registration.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { SetNewPasswordComponent } from './set-new-password/set-new-password.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';


const routes: Routes = [
  // {path:'set-pass',component:SetNewPasswordComponent}

  {path:'', component:HomePageComponent},


  // {path:'', component:RegistrationPageComponent}

  //{path:'', component:AppComponent},
  {  path:'adminLogin', component:AdminLoginComponent},
  {  path:'adminLogout', component:HomePageComponent},
  {  path:'userLogin', component:LoginPageComponent},
  {  path:'netBankRegister', component:NetbankingRegistrationComponent},
  {  path:'adminApproval', component:AdminApprovalComponent},
  {  path:'userDashboard', component:UserDashboardComponent},
  { path:'register', component:RegistrationPageComponent },
  { path:'forgotId',component:ForgotUserIdComponent},
  { path:'forgotPass',component:ForgotPasswordComponent},
  { path:'checkStatus', component:CheckStatusComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
