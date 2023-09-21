import { AppComponent } from "./app/app.component";
import { provideRouter } from "@angular/router";
import { APP_ROUTES } from "./app/app.routes";
import { bootstrapApplication } from "@angular/platform-browser";
import { HttpClientModule } from "@angular/common/http";
import { importProvidersFrom } from "@angular/core";


bootstrapApplication(AppComponent, {
  providers: [
    importProvidersFrom(HttpClientModule),
    provideRouter(APP_ROUTES)
  ]
}).catch(err => console.error(err));
