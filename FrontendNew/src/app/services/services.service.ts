import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { AddTransaction, Beneficiary, ChangePassword, LoginCreds, NetbankingRegistration, UserDetails } from '../models/models';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  constructor(private http: HttpClient) { }

  register(user : UserDetails) : Observable<any>{
    let url = "http://localhost:8084/register";
    return this.http.post(url, user);
  }

  login(loginCreds: LoginCreds) : Observable<any> {
    let url = "http://localhost:8084/login";
    return this.http.post(url, loginCreds)
  }

  netbankingRegistration(credentials : NetbankingRegistration): Observable<any> {
    let url = "http://localhost:8084/netBanking";
    return this.http.post(url, credentials)
  }

  addBeneficiary(benf : Beneficiary) : Observable<any>{
    let url = "http://localhost:8084/addBeneficiary";
    return this.http.post(url, benf);
  }

  addTransaction(transaction : AddTransaction) : Observable<any>{
    let url = "http://localhost:8084/addTransaction";
    return this.http.post(url, transaction);
  }

  viewBeneficiary(userId){
    return this.http.get<any>("http://localhost:8084/viewBeneficiaryList/"+userId)
  }
  changePassword(creds : ChangePassword) : Observable<any>{
    let url = "http://localhost:8084/forgetLoginPassword";
    return this.http.post(url, creds);
  }

}
