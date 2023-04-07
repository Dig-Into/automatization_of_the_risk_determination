import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { MerePregledComponent } from "./mere-pregled.component";

const routes: Routes = [
    {
        path: '',
        component: MerePregledComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class MerePregledRoutingModule {}