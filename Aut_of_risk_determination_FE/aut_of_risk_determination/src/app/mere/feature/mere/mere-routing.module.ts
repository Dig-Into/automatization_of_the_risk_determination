import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { MereComponent } from "./mere.component";

const routes: Routes = [
    {
        path: '',
        component: MereComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class MereRoutingModule {}