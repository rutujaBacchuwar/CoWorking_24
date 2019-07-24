import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { LocationComponent } from '../location/location.component';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css'],
  providers: [MatDialog]
})
export class LandingPageComponent implements OnInit {

  constructor(public dialog: MatDialog) { }
  dialogRef:any;
  openDialog(): void {
    this.dialogRef = this.dialog.open(LocationComponent, {
      width: '800px',
    });
  }

  ngOnInit() {
    this.openDialog();
    }
}
