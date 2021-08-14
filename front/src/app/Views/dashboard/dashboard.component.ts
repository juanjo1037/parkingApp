import { Component, OnInit } from '@angular/core';
import {ApiService} from '../../Services/api/api.service';
import {Router} from '@angular/router'
import {billListI} from '../../Models/billlist.interface'
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
   bills: billListI[] = [];
  constructor(private api:ApiService, private router:Router) { }

  ngOnInit(): void {
    this.api.getAllBills().subscribe(data =>{
      console.log(data)
    })
  }

}
