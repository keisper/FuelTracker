import React, {useState} from "react";

import {Drawer} from "antd"
import {MdDehaze} from "react-icons/md";

import './Sidenav.css'
import SidenavLink from "./SidenavLink";


export default function Sidenav({header, footer}) {

    const [isMobile, setIsMobile] = useState(false);
    const showDrawer = () => setIsMobile(true);
    const closeDrawer = () => setIsMobile(false);

    return (
        <>
            <div className="sidenav--wrapper my-primary-color">
                <ul className="sidenav--header">
                    <li className="sidenav-nav-link sidenav--menu"><a href="#" onClick={showDrawer}><MdDehaze/></a></li>
                    { header.map(({_id, ...elt}) => <SidenavLink key={_id} {...elt}/>) }
                </ul>
                <ul className="sidenav--footer">
                    { footer.map(({_id, ...elt}) => <SidenavLink key={_id} {...elt}/>) }
                </ul>
            </div>
            <Drawer
                title="FuelTracker"
                placement="left"
                closable={false}
                onClose={closeDrawer}
                visible={isMobile}
            >
                <ul className="sidenav__mobile--header">
                    { header.map(({_id, ...elt}) => <SidenavLink key={_id} {...elt}/>) }
                    { footer.map(({_id, ...elt}) => <SidenavLink key={_id} {...elt}/>) }
                </ul>
            </Drawer>
        </>
    )
}