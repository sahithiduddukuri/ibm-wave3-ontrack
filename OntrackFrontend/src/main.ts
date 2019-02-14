<<<<<<< HEAD
// import 'hammerjs';
=======
//import 'hammerjs';
>>>>>>> 26cd6d9b87f00ea4917739773564eeb835638d78
import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
