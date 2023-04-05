import { DangerDetails } from "./DangerDetails";

export class Mera {
    constructor(
        public id: number,
        public riskFactorValue: number,
        public measurementImplFreq: string,
        public description: string,
        public dangerDetails: DangerDetails
    ) {

    }
}