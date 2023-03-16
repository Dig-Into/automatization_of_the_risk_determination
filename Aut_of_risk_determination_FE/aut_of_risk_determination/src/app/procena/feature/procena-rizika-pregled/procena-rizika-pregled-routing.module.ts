import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ProcenaRizikaPregledComponent } from "./procena-rizika-pregled.component";

const routes: Routes = [
    {
        path: '',
        component: ProcenaRizikaPregledComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class ProcenaRizikaRoutingModule {}