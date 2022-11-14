import { NgModule } from '@angular/core';
import { MatNativeDateModule } from '@angular/material/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FaIconLibrary, FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faStackOverflow } from '@fortawesome/free-brands-svg-icons';
import { faCoffee, faFilm, faTrash, faPenToSquare } from '@fortawesome/free-solid-svg-icons';
import { AngularMaterialModule } from '../AngularMaterialModule';
import {MatCardModule} from '@angular/material/card';

@NgModule({
  declarations: [],
  imports: [
    FontAwesomeModule
  ],
  exports:[
    FontAwesomeModule,
    MatNativeDateModule,
    MatCardModule,
    AngularMaterialModule,
    BrowserAnimationsModule
  ]
})
export class SharedModule { 
  constructor(library: FaIconLibrary) {
    library.addIcons(
      faCoffee,
      faStackOverflow,
      faFilm,
      faTrash,
      faPenToSquare,
    );
  }
}
