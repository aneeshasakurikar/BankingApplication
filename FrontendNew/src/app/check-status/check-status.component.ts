import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-check-status',
  templateUrl: './check-status.component.html',
  styleUrls: ['./check-status.component.css']
})
export class CheckStatusComponent implements OnInit {
  userId;
  constructor(private http: HttpClient,private router:Router) { }

  ngOnInit() {
  }
  checkStatus(){
    console.log(this.userId)
    this.http.get<any>("http://localhost:8084/checkStatus/"+this.userId)
      .subscribe(response=>{
        alert(JSON.stringify(response.message));
      })
      this.router.navigate(['']);
    }
}
