import styles from "../styles/Login.module.css";
import Link from "next/link"
import getDataCovid19 from "./mockup_data/dataCovid19";

export default function Home() {
  return (
    <div className={styles.container}>
      <main className={styles.main}>
        <table className={styles.table}>
          <thead>
            <tr className={styles.tr}>
              <th className={styles.th}>Date</th>
              <th className={styles.th}>Confirmed</th>
              <th className={styles.th}>Actives</th>
              <th className={styles.th}>Recovered</th>
              <th className={styles.th}>Deaths</th>
            </tr>
          </thead>
          <tbody>
            {getDataCovid19().map(data => (
              <tr className={styles.tr} >
                 <td className={styles.td}>{data.Date}</td>
                <td className={styles.td}>{data.Confirmed}</td>
                <td className={styles.td}>{data.Actives}</td>
                <td className={styles.td}>{data.Recovered}</td>
                <td className={styles.td}>{data.Deaths}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </main>
    </div>
  );
}