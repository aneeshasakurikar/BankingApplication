import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddTransaction } from '../models/models';
import { ServicesService } from '../services/services.service';

@Component({
  selector: 'app-neft-form',
  templateUrl: './neft-form.component.html',
  styleUrls: ['./neft-form.component.css']
})
export class NeftFormComponent implements OnInit {
  transaction: AddTransaction = new AddTransaction();
  benf;
  constructor(private service: ServicesService, private router:Router) { }
  
  ngOnInit():void {
    this.service.viewBeneficiary(sessionStorage.getItem('userId'))
    .subscribe(data => {
        console.log(data)
        this.benf = data; 
        console.log(this.benf);
      })
  }
  register() {
    this.service.addTransaction(this.transaction).subscribe(response => {
      
          alert(JSON.stringify(response.message));
          location.reload();
      
      
    })
    
  }

}
