import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardComponent} from './Views/dashboard/dashboard.component';
import {NewBillComponent} from './Views/new-bill/new-bill.component';
import {EditBillComponent} from './Views/edit-bill/edit-bill.component';

const routes: Routes = [
  {path:'', redirectTo:'dashboard' , pathMatch:'full'},
  {path:'dashboard', component: DashboardComponent },
  {path:'new-bill', component: NewBillComponent },
  {path:'edit-bill/:plate', component: EditBillComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [DashboardComponent,NewBillComponent,EditBillComponent]
