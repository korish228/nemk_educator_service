import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ApiService {
  private BASE_URL = 'http://localhost:8082/api/';
  private ALL_USERS_URL = `${this.BASE_URL}\\users\\all`;
  private ALL_COURSES_URL = `${this.BASE_URL}\\courses\\all`;
  private ALL_TASKS_URL = `${this.BASE_URL}\\tasks\\all`;

  private COURSES_BY_USER_URL = `${this.BASE_URL}\\courses\\byUser\\`;
  private TASKS_BY_COURSE_URL = `${this.BASE_URL}\\tasks\\byCourse\\`;

  // courses/byUser/


  constructor(private http: HttpClient) {

  }

  getAllUsers() : Observable<User[]>{
    return this.http.get<User[]>(this.ALL_USERS_URL);
  }

  getAllCourses() : Observable<Course[]>{
    return this.http.get<Course[]>(this.ALL_COURSES_URL);
  }
}
