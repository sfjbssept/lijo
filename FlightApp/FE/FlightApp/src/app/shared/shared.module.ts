import { NgModule } from '@angular/core';
import { FaIconLibrary, FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faStackOverflow } from '@fortawesome/free-brands-svg-icons';
import { faCoffee, faFilm, faTrash, faPenToSquare } from '@fortawesome/free-solid-svg-icons';

@NgModule({
  declarations: [],
  imports: [
    FontAwesomeModule
  ],
  exports:[
    FontAwesomeModule
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
