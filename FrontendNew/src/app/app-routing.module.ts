import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { AddBeneficiaryComponent } from './add-beneficiary/add-beneficiary.component';

import { AdminApprovalComponent } from './admin-approval/admin-approval.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AppComponent } from './app.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { CheckStatusComponent } from './check-status/check-status.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ForgotUserIdComponent } from './forgot-user-id/forgot-user-id.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ImpsFormComponent } from './imps-form/imps-form.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { LogoutComponent } from './logout/logout.component';
import { NeftFormComponent } from './neft-form/neft-form.component';
import { NetbankingRegistrationComponent } from './netbanking-registration/netbanking-registration.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { RtgsFormComponent } from './rtgs-form/rtgs-form.component';
import { SetNewPasswordComponent } from './set-new-password/set-new-password.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { FundsTransferComponent } from './funds-transfer/funds-transfer.component';
import { AccountSummaryComponent } from './account-summary/account-summary.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';

const routes: Routes = [
  // {path:'set-pass',component:SetNewPasswordComponent}


  {path:'', component:HomePageComponent},

  {  path:'adminLogin', component:AdminLoginComponent},
  {  path:'userLogin', component:LoginPageComponent},
  {  path:'userDetails', component:UserDetailsComponent},
  {  path:'accountDetails', component:AccountDetailsComponent},
  {  path:'netBankRegister', component:NetbankingRegistrationComponent},
  {  path:'adminApproval', component:AdminApprovalComponent},
  {  path:'userDashboard', component:UserDashboardComponent},
  { path:'register', component:RegistrationPageComponent },
  { path:'forgotId',component:ForgotUserIdComponent},
  { path:'forgotPass',component:ForgotPasswordComponent},
  { path:'checkStatus', component:CheckStatusComponent},
  { path: 'rtgsPayment', component:RtgsFormComponent },
  { path: 'impsPayment', component:ImpsFormComponent },
  { path: 'neftPayment', component:NeftFormComponent },
  { path: 'addBeneficiary', component:AddBeneficiaryComponent },
  { path: 'changePassword', component:ChangePasswordComponent },
  { path: 'logout', component:LogoutComponent },
  { path: 'setPassword', component:SetNewPasswordComponent },
  { path: 'fundsTransfer', component:FundsTransferComponent },
  { path: 'accountSummary', component:AccountSummaryComponent },
  { path: 'welcome', component:WelcomePageComponent }


  // {path:'', component:AppComponent},
  // { path:'register', component:RegistrationPageComponent },
  // { path:'forgotId',component:ForgotUserIdComponent},
  // { path:'forgotPass',component:ForgotPasswordCompo 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
