
import React from 'react';
import { NSRCarousel } from "./components/NSRCarousel";
import { NSRExploreTopProducts } from "./components/NSRExploreTopProducts";
import { NSRHeros } from "./components/NSRHeros";
import { NSRServices } from "./components/NSRServices";

export const NSRHomePage = () => {
    return (
        <>
            <NSRExploreTopProducts/>
            <NSRCarousel/>
            <NSRHeros/>
            <NSRServices/>
        </>
    );
}