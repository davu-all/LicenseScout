/**
 * Copyright 2019 Association for the promotion of open-source insurance software and for the establishment of open interface standards in the insurance industry (Verein zur Förderung quelloffener Versicherungssoftware und Etablierung offener Schnittstellenstandards in der Versicherungsbranche)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aposin.licensescout.execution;

import java.util.Arrays;
import java.util.List;

import org.aposin.licensescout.configuration.OutputFileType;
import org.aposin.licensescout.exporter.CsvExporter;
import org.aposin.licensescout.exporter.HtmlExporter;
import org.aposin.licensescout.exporter.IReportExporter;
import org.aposin.licensescout.exporter.TxtExporter;

/**
 * Factory for creating report exporter instances.
 * 
 * <p>Supports the following output file types:</p>
 * <ul>
 * <li>{@link OutputFileType#CSV}</li>
 * <li>{@link OutputFileType#HTML}</li>
 * <li>{@link OutputFileType#TXT}</li>
 * </ul>
 *
 */
public class StandardReportExporterFactory implements IReportExporterFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OutputFileType> getSupportedOutputFileTypes() {
        return Arrays.asList(OutputFileType.CSV, OutputFileType.HTML, OutputFileType.TXT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IReportExporter getReportExporter(final OutputFileType outputFileType) {
        switch (outputFileType) {
            case CSV:
                return CsvExporter.getInstance();
            case HTML:
                return HtmlExporter.getInstance();
            case TXT:
                return TxtExporter.getInstance();
            default:
                throw new IllegalArgumentException("Unhandled OutputFileType: " + outputFileType);
        }
    }

}
