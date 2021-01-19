import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { CheckStatusComponent } from './check-status/check-status.component';
import { NetbankingRegistrationComponent } from './netbanking-registration/netbanking-registration.component';
import { ForgotUserIdComponent } from './forgot-user-id/forgot-user-id.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { LogoutComponent } from './logout/logout.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SetNewPasswordComponent } from './set-new-password/set-new-password.component';

import { AdminLoginComponent } from './admin-login/admin-login.component';
import { HttpClientModule } from '@angular/common/http';

import { ServicesService } from './services/services.service';
import { AdminApprovalComponent } from './admin-approval/admin-approval.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AccountSummaryComponent } from './account-summary/account-summary.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { NeftFormComponent } from './neft-form/neft-form.component';
import { ImpsFormComponent } from './imps-form/imps-form.component';
import { RtgsFormComponent } from './rtgs-form/rtgs-form.component';
import { TransferSuccessComponent } from './transfer-success/transfer-success.component';
import { AddBeneficiaryComponent } from './add-beneficiary/add-beneficiary.component';
import { FundsTransferComponent } from './funds-transfer/funds-transfer.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    RegistrationPageComponent,
    LoginPageComponent,
    CheckStatusComponent,
    NetbankingRegistrationComponent,
    ForgotUserIdComponent,
    ForgotPasswordComponent,

    LogoutComponent,

    SetNewPasswordComponent,

    AdminLoginComponent,

    AdminApprovalComponent,

    UserDashboardComponent,

    AccountSummaryComponent,

    UserDetailsComponent,

    ChangePasswordComponent,

    NeftFormComponent,

    ImpsFormComponent,

    RtgsFormComponent,

    TransferSuccessComponent,

    AddBeneficiaryComponent,

    FundsTransferComponent,

    AccountDetailsComponent,

    HeaderComponent,

    FooterComponent,

    WelcomePageComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NoopAnimationsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
