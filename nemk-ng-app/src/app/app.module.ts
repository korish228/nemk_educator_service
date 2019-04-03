import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { MessagesComponent } from './messages/messages.component';
import { CoursesComponent } from './courses/courses.component';
import { ProfileComponent } from './profile/profile.component';
import { CurrentCourseComponent } from './current-course/current-course.component';
import { RouterModule, Routes } from '@angular/router';
import { CurrentTaskComponent } from './current-task/current-task.component';
import { FriendsComponent } from './friends/friends.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

const appRoutes: Routes = [
  {
    path: 'messages',
    component: MessagesComponent
  },
  {
    path: 'courses',
    component: CoursesComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: '',
    component: ProfileComponent
  },
  {
    path: 'current_course',
    component: CurrentCourseComponent
  },
  {
    path: 'current_task',
    component: CurrentTaskComponent
  },
  {
    path: 'friends',
    component: FriendsComponent
  }
];


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    MessagesComponent,
    CoursesComponent,
    ProfileComponent,
    CurrentCourseComponent,
    CurrentTaskComponent,
    FriendsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes, { enableTracing: true })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
