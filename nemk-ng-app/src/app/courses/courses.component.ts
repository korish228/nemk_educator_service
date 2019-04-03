import { Component, OnInit } from '@angular/core';
import {Course} from '../models/course';
import {ApiService} from '../shared/api-service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  courses: Course [] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.getAllCourses();
  }


  public getAllCourses() {
    this.apiService.getAllCourses().subscribe(
      res => {
        this.courses = res;
        console.log(res);
      },
        error1 => {
          alert('error has occured');
        }
    );
  }
}
