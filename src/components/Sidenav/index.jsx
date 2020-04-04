import React, {useState} from "react";

import {Drawer} from "antd"
import {MdDehaze, MdPowerSettingsNew} from "react-icons/md";

import './Sidenav.css'
import {Link} from "react-router-dom";


export default function Sidenav({header, footer, current, setCurrent}) {

    const [isMobile, setIsMobile] = useState(false);

    const handleClick = (page) => setCurrent(page);
    const showDrawer = () => setIsMobile(true);
    const closeDrawer = () => setIsMobile(false);

    return (
        <>
            <div className="sidenav--wrapper my-primary-color">
                <ul className="sidenav--header">
                    <li className="sidenav-nav-link sidenav--menu"><a href="#" onClick={showDrawer}><MdDehaze/></a></li>
                    {header.map(
                        ({_id, title, component}, index) => (
                            <li key={`li-link-${_id}`} className={`sidenav-nav-link ${_id === current && "active"}`}>
                                {index === 0 ?
                                    <Link to="/root" onClick={() => handleClick(_id)}>{component}</Link> :
                                    <a href={`#${_id}`} onClick={() => handleClick(_id)}>{component}</a>}
                            </li>
                        )
                    )}
                </ul>
                <ul className="sidenav--footer">
                    {footer.map(
                        ({_id, title, component, active}) => (
                            <li key={`li-link-${_id}`} className={`sidenav-nav-link ${active && "active"}`}>
                                <a href={`#${_id}`} onClick={() => handleClick(_id)}>{component}</a>
                            </li>
                        )
                    )}
                    <li className="sidenav-nav-link"><a to="/logout"><MdPowerSettingsNew/></a></li>
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
                    {header.map(
                        ({_id, title, component}, index) => (
                            <li key={`li-link-${_id}`} className={`sidenav-nav-link ${_id === current && "active"}`}>
                                {index === 0 ?
                                    <Link to="/root" onClick={() => handleClick(_id)}>{component} {title}</Link> :
                                    <a href={`#${_id}`} onClick={() => handleClick(_id)}>{component} {title}</a>}
                            </li>
                        )
                    )}
                    {footer.map(
                        ({_id, title, component, active}) => (
                            <li key={`li-link-${_id}`} className={`sidenav-nav-link ${active && "active"}`}>
                                <a href={`#${_id}`} onClick={() => handleClick(_id)}>{component} {title}</a>
                            </li>
                        )
                    )}
                    <li className="sidenav-nav-link"><a to="/logout"><MdPowerSettingsNew/> Déconnexion</a></li>
                </ul>
            </Drawer>
        </>
    )
}